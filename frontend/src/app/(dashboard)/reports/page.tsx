import { ReportsOverview } from '@/components/reports/reports-overview';

export default function ReportsPage() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold">Báo cáo</h1>
        <p className="text-muted-foreground">
          Xem báo cáo doanh thu, công nợ và phân tích kinh doanh
        </p>
      </div>
      <ReportsOverview />
    </div>
  );
}
